

import org.example.CU;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class CUTeste {

    private CU cu;

    @BeforeEach
    public void setup() {
        cu = new CU("Matemática", 5); // Cria uma UC com nome "Matemática" e 5 alunos no máximo
    }

    @Test
    public void testInsertMarkCU() {
        cu.insertMarkCU(1, 10.0);
        assertEquals(10.0, cu.searchStudent(1), "A nota do aluno 1 deve ser 10.0");
    }

    @Test
    public void testSearchStudent_NotFound() {
        assertEquals(-1, cu.searchStudent(2), "Aluno não deve ser encontrado, deve retornar -1");
    }

    @ParameterizedTest
    @CsvSource({
            "1, 10.0",
            "2, 8.0",
            "3, 9.5",
            "4, 12.0"
    })
    public void testInsertAndSearchStudent(int numStudent, double mark) {
        cu.insertMarkCU(numStudent, mark);
        assertEquals(mark, cu.searchStudent(numStudent), "A nota do aluno " + numStudent + " deve ser " + mark);
    }

    @Test
    public void testAverageCU() {
        cu.insertMarkCU(1, 10.0);
        cu.insertMarkCU(2, 8.0);
        assertEquals(9.0, cu.averageCU(), "A média deve ser 9.0");
    }

    @ParameterizedTest
    @CsvSource({
            "1, 10.0, true",
            "2, 8.0, false",
            "3, 9.5, true",
            "4, 12.0, true"
    })
    public void testIsApproved(int numStudent, double mark, boolean expected) {
        cu.insertMarkCU(numStudent, mark);
        assertEquals(expected, cu.isApproved(numStudent), "O aluno " + numStudent + " deve ser aprovado: " + expected);
    }
}