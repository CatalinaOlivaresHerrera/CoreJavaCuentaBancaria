import clases.Persona;
import clases.CuentaBancaria;

public class Aplicacion {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA BANCARIO ===\n");
        
        // Crear instancias de Persona
        Persona persona1 = new Persona("Juan Pérez", 30);
        Persona persona2 = new Persona("María García", 25);
        Persona persona3 = new Persona("Carlos López", 35);
        Persona persona4 = new Persona("Ana Martínez", 28);
        
        // Crear instancias de CuentaBancaria asociadas con las personas
        CuentaBancaria cuenta1 = new CuentaBancaria(1000.0, persona1);
        CuentaBancaria cuenta2 = new CuentaBancaria(2500.0, persona2);
        CuentaBancaria cuenta3 = new CuentaBancaria(500.0, persona3);
        CuentaBancaria cuenta4 = new CuentaBancaria(0.0, persona4); // Cuenta sin saldo inicial
        
        System.out.println("=== OPERACIONES BANCARIAS ===");
        
        // Realizar operaciones en las cuentas
        System.out.println("\n--- Operaciones en Cuenta 1 ---");
        cuenta1.depositar(500.0);
        cuenta1.retirar(200.0);
        
        System.out.println("\n--- Operaciones en Cuenta 2 ---");
        cuenta2.retirar(3000.0); // Intento de retiro con fondos insuficientes
        cuenta2.retirar(1000.0); // Retiro exitoso
        
        System.out.println("\n--- Operaciones en Cuenta 3 ---");
        cuenta3.depositar(1000.0);
        cuenta3.retirar(400.0);
        
        System.out.println("\n--- Operaciones en Cuenta 4 ---");
        cuenta4.depositar(1500.0);
        cuenta4.retirar(200.0);
        
        // Mostrar saldos actuales
        System.out.println("\n=== SALDOS ACTUALES ===");
        System.out.println("Cuenta 1 - Saldo actual: $" + cuenta1.getSaldo());
        System.out.println("Cuenta 2 - Saldo actual: $" + cuenta2.getSaldo());
        System.out.println("Cuenta 3 - Saldo actual: $" + cuenta3.getSaldo());
        System.out.println("Cuenta 4 - Saldo actual: $" + cuenta4.getSaldo());
        
        // Ejecutar método estático para imprimir información de todas las cuentas
        CuentaBancaria.imprimeInformacionDeTodasLasCuentas();
    }
}