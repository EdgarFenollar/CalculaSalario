package es.iesmz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoBRTest {

    @BeforeEach
    public void before(){
        System.out.println("EXECUTE PROVA");
    }

    // 1 Commit
    @Test
    public void calculaSalarioNeto1(){
        assertEquals(1640, EmpleadoBR.calculaSalarioNeto(2000));
    }

    @Test
    public void calculaSalarioNeto2(){
        assertEquals(1230, EmpleadoBR.calculaSalarioNeto(1500));
    }

    @Test
    public void calculaSalarioNeto3(){
        assertEquals(1259.9916f, EmpleadoBR.calculaSalarioNeto(1499.99f), 0.0011f);
    }

    @Test
    public void calculaSalarioNeto4(){
        assertEquals(1050, EmpleadoBR.calculaSalarioNeto(1250));
    }

    @Test
    public void calculaSalarioNeto5(){
        assertEquals(840, EmpleadoBR.calculaSalarioNeto(1000), 0.01);
    }
    // 2 Commit
    @Test
    public void calculaSalarioNeto6(){
        assertEquals(999, EmpleadoBR.calculaSalarioNeto(999));
    }

    @Test
    public void calculaSalarioNeto7(){
        assertEquals(500, EmpleadoBR.calculaSalarioNeto(500));
    }

    @Test
    public void calculaSalarioNeto8(){
        assertEquals(0, EmpleadoBR.calculaSalarioNeto(0));
    }

    @Test
    public void calculaSalarioNeto9(){
        assertEquals(-1, EmpleadoBR.calculaSalarioNeto(-1));
    }

    @Test
    public void calculaSalarioBruto1(){
        assertEquals(1360, EmpleadoBR.calculaSalarioBruto(TipoEmpleado.vendedor, 2000, 8));
    }
    // 3 Commit
    @Test
    public void calculaSalarioBruto2(){
        assertEquals(1260, EmpleadoBR.calculaSalarioBruto(TipoEmpleado.vendedor, 1500, 3));
    }

    @Test
    public void calculaSalarioBruto3(){
        assertEquals(1100, EmpleadoBR.calculaSalarioBruto(TipoEmpleado.vendedor, 1499.99f, 0));
    }

    @Test
    public void calculaSalarioBruto4(){
        assertEquals(1760, EmpleadoBR.calculaSalarioBruto(TipoEmpleado.encargado, 1250, 8));
    }

    @Test
    public void calculaSalarioBruto5(){
        assertEquals(1600, EmpleadoBR.calculaSalarioBruto(TipoEmpleado.encargado, 1000, 0));
    }

    @Test
    public void calculaSalarioBruto6(){
        assertEquals(1560, EmpleadoBR.calculaSalarioBruto(TipoEmpleado.encargado, 999.99f, 3));
    }
    // 4 Commit
    @Test
    public void calculaSalarioBruto7(){
        assertEquals(1500, EmpleadoBR.calculaSalarioBruto(TipoEmpleado.encargado, 500, 0));
    }

    @Test
    public void calculaSalarioBruto8(){
        assertEquals(1660, EmpleadoBR.calculaSalarioBruto(TipoEmpleado.encargado, 0, 8));
    }

    @Test
    public void calculaSalarioBruto9(){
        assertEquals(-1, EmpleadoBR.calculaSalarioBruto(TipoEmpleado.vendedor, -1, 8));
    }

    @Test
    public void calculaSalarioBruto10(){
        assertEquals(-1, EmpleadoBR.calculaSalarioBruto(TipoEmpleado.vendedor, 1500, -1));
    }

    @Test
    public void calculaSalarioBruto11(){
        assertEquals(-1, EmpleadoBR.calculaSalarioBruto(null, 1500, 8));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "datos_empleados.csv", numLinesToSkip = 1)
    void testCalculaSalarioBruto(float expectedSalarioBruto, TipoEmpleado tipoEmpleado, float ventasMes, float horasExtras) {
        float salarioBruto = EmpleadoBR.calculaSalarioBruto(tipoEmpleado, ventasMes, horasExtras);
        assertEquals(expectedSalarioBruto, salarioBruto, 0.001);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "datos_salario_bruto.csv", numLinesToSkip = 1)
    void testCalculaSalarioNeto(float expectedSalarioNeto, float salarioBruto) {
        float salarioNeto = EmpleadoBR.calculaSalarioNeto(salarioBruto);
        assertEquals(expectedSalarioNeto, salarioNeto, 0.001);
    }

    @ParameterizedTest
    @CsvSource({
            "vendedor, 1500, -1, -1",
            "encargado, 999.99f, 3, 1560"
    })
    void testCalculaSalarioBrutoCSV1(TipoEmpleado tipoEmpleado, float ventasMes, float horasExtras, float expectedSalarioBruto) {
        float salarioBruto = EmpleadoBR.calculaSalarioBruto(tipoEmpleado, ventasMes, horasExtras);
        assertEquals(expectedSalarioBruto, salarioBruto, 0.001);
    }

    @ParameterizedTest
    @CsvSource({
            "1050,1250",
            "1230,1500",
            "999,999"
    })
    void testCalculaSalarioBrutoCSV2(float expectedSalarioNeto, float salarioBruto) {
        float salarioNeto = EmpleadoBR.calculaSalarioNeto(salarioBruto);
        assertEquals(expectedSalarioNeto, salarioNeto, 0.001);
    }
}