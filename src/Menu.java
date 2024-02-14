import java.util.Collections;
import java.util.Scanner;

public class Menu {

    Scanner teclado = new Scanner(System.in);

    public void exibirMenu() {
        int opcao = 1;

        System.out.println("Bem vindo ao aplicativo de compras Alura");

        while (opcao != 0) {
            try {
                System.out.println("Digite o limite do seu cartão em reais: ");
                double cartaolimite = teclado.nextDouble();
                CartaoDeCredito cartao = new CartaoDeCredito(cartaolimite);

                while (opcao != 0) {
                    try {
                        System.out.println("Digite a descrição da compra:");
                        String comprasDescricao = teclado.next();

                        System.out.println("Digite o valor da compra:");
                        double valorCompra = teclado.nextDouble();

                        Compra compra = new Compra(comprasDescricao, valorCompra);
                        boolean compraRealizada = cartao.adCompras(compra);

                        if (compraRealizada) {
                            System.out.println("Compra realizada!");
                            while (true) {
                                System.out.println("Digite 0 para sair ou 1 para continuar");
                                String numero = teclado.next();
                                if (numero.equals("0")) {
                                    opcao = 0;
                                    break;
                                } else if (numero.equals("1")) {
                                    opcao = 1;
                                    break;
                                } else {
                                    System.out.println("Erro, digite 0 ou 1");
                                }
                            }
                        } else {
                            System.out.println("Saldo insuficiente!");
                            opcao = 0;
                        }

                        System.out.println("***********************");
                        System.out.println("COMPRAS REALIZADAS:\n");
                        Collections.sort(cartao.getCompras());
                        for (Compra c : cartao.getCompras()) {
                            System.out.println(c.getComprasDescricao() + " - R$ " + c.getValorDacompra());
                        }
                        System.out.println("\n***********************");

                        System.out.println("\nSaldo do cartão R$: " + cartao.getSaldo());

                    } catch (Exception e) {
                        System.out.println("Erro, entre com o dado correto");
                        teclado.nextLine();
                    }
                }

            } catch (Exception e) {
                System.out.println("Erro, entre com o dado correto");
                teclado.nextLine();
            }
        }
    }
}
