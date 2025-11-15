package clases;

import java.util.ArrayList;
import java.util.Random;

public class CuentaBancaria {
    private double saldo;
    private Persona titular;
    private int numeroCuenta;

    private static ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<>();

    public CuentaBancaria(double saldo, Persona titular) {
        this.saldo = saldo;
        this.titular = titular;

        Random random = new Random();
        this.numeroCuenta = 100000 + random.nextInt(900000); 

        listaDeCuentasBancarias.add(this);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public static ArrayList<CuentaBancaria> getListaDeCuentasBancarias() {
        return listaDeCuentasBancarias;
    }

    public static void setListaDeCuentasBancarias(ArrayList<CuentaBancaria> listaDeCuentasBancarias) {
        CuentaBancaria.listaDeCuentasBancarias = listaDeCuentasBancarias;
    }

    // Metodo para depositar

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Deposito exitoso: $" + monto);

        }
    }

    public void retirar(double monto) {
        if (monto > 0) {
            if (monto <= saldo) {
                saldo -= monto;
                System.out.println("Retiro exitoso: $" + monto);
            } else {
                System.out.println("Fondos insuficientes. Saldo actual: $" + saldo);
            }
        } else {
            System.out.println("El monto a retirar debe ser positivo");
        }
    }

    // Método para desplegar información de la cuenta
    public void despliegaInformacion() {
        System.out.println("=== Información de la Cuenta ===");
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo: $" + saldo);
        System.out.println("=== Información del Titular ===");
        titular.despliegaInformacion();
        System.out.println("===============================");
    }

    // Método estático para imprimir información de todas las cuentas
    public static void imprimeInformacionDeTodasLasCuentas() {
        System.out.println("\n=== INFORMACIÓN DE TODAS LAS CUENTAS BANCARIAS ===");
        if (listaDeCuentasBancarias.isEmpty()) {
            System.out.println("No hay cuentas bancarias registradas.");
        } else {
            for (int i = 0; i < listaDeCuentasBancarias.size(); i++) {
                CuentaBancaria cuenta = listaDeCuentasBancarias.get(i);
                System.out.println("Cuenta #" + (i + 1) + ":");
                cuenta.despliegaInformacion();
                System.out.println();
            }
        }
        System.out.println("Total de cuentas: " + listaDeCuentasBancarias.size());
    }
}
