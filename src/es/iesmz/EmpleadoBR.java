package es.iesmz;

public class EmpleadoBR {

    public static float calculaSalarioBruto(TipoEmpleado tipoEmpleado, float ventasMes, float horasExtras){
        float salario = 0;
        if(tipoEmpleado == TipoEmpleado.vendedor){
            salario = 1000;
        } else if (tipoEmpleado == TipoEmpleado.encargado){
            salario = 1500;
        }

        if (ventasMes >= 1000){
            salario += 100;
        } else if (ventasMes >= 1500){
            salario += 200;
        }

        if (!(horasExtras == 0)){
            salario += (horasExtras * 20);
        }

        if (tipoEmpleado == null || ventasMes < 0 || horasExtras < 0){
            return salario = -1;
        }
        return salario;
    }

    public static float calculaSalarioNeto(float salarioBruto){
        float retencion = 0;
        if (salarioBruto < 1000){
            return salarioBruto;
        } else if (salarioBruto >= 1000 && salarioBruto < 1500){
            retencion = 16;
            return salarioBruto * (1-(retencion/100));
        } else if (salarioBruto >= 1500){
            retencion = 18;
            return salarioBruto * (1-(retencion/100));
        }

        if (salarioBruto < 0){
            return -1;
        }
        return salarioBruto;
    }
}
