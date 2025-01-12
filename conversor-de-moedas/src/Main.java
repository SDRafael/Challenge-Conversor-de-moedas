import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BuscaCotacao cotacoes = new BuscaCotacao();
        Map<String, Double> cotacoesRates;

        String escolherMoeda;
        do{
            System.out.println("""
                Escolha uma opção
                <<<<<<<<>>>>>><<<<<<<<>>>>>>
                1 - Real para Dolar
                2 - Real para Yuan
                3 - Real para Euro
                4 - Dolar para Real               
                5 - Euro para Real
                6 - Yuan para Real
                
                0 - Sair
                <<<<<<<<>>>>>><<<<<<<<>>>>>>               
                """);
            escolherMoeda = scanner.nextLine();
            switch (escolherMoeda) {
                case "0" -> System.out.println("programa encerrado");
                case "1" -> {
                    System.out.println("Digite o valor em Real para converter em Dolar");

                    cotacoesRates = cotacoes.buscarCotacao("BRL").conversion_rates();

                    double valorDolar = cotacoesRates.get("USD");

                    double meuValorEmReais = scanner.nextDouble();
                    scanner.nextLine();

                    double totalEmDolar = meuValorEmReais*valorDolar;
                    System.out.println(String.format("O seu valor em Real R$%.2f valem $%.2f Dolar", meuValorEmReais, totalEmDolar));

                }
                case "2" -> {
                    System.out.println("Digite o valor em Real para converter em Yuan");
                    cotacoesRates = cotacoes.buscarCotacao("BRL").conversion_rates();

                    double valorYuan = cotacoesRates.get("CNY");

                    double meuValorEmReais = scanner.nextDouble();
                    scanner.nextLine();

                    double totalEmYuan = meuValorEmReais*valorYuan;
                    System.out.println(String.format("O seu valor em Real R$%.2f valem ¥%.2f Yuan", meuValorEmReais, totalEmYuan));

                }
                case "3" -> {
                    System.out.println("Digite o valor em Real para converter em Euro");
                    cotacoesRates = cotacoes.buscarCotacao("BRL").conversion_rates();

                    double valorEuro = cotacoesRates.get("EUR");

                    double meuValorEmReais = scanner.nextDouble();
                    scanner.nextLine();

                    double totalEmEuro = meuValorEmReais*valorEuro;
                    System.out.println(String.format("O seu valor em Real R$%.2f valem €%.2f Euro", meuValorEmReais, totalEmEuro));
                }
                case "4" -> {
                    System.out.println("Digite o valor em Dolar para converter em Real");
                    cotacoesRates = cotacoes.buscarCotacao("USD").conversion_rates();

                    double valorReal = cotacoesRates.get("BRL");

                    double meuValorEmDolar = scanner.nextDouble();
                    scanner.nextLine();

                    double totalEmReal = meuValorEmDolar * valorReal;
                    System.out.println(String.format("O seu valor em Dolar $%.2f valem R$%.2f Real", meuValorEmDolar, totalEmReal));
                }
                case "5" -> {
                    System.out.println("Digite o valor em Euro para converter em Real");
                    cotacoesRates = cotacoes.buscarCotacao("EUR").conversion_rates();

                    double valorReal = cotacoesRates.get("BRL");

                    double meuValorEmEuro = scanner.nextDouble();
                    scanner.nextLine();

                    double totalEmReal = meuValorEmEuro * valorReal;
                    System.out.println(String.format("O seu valor em Euro €%.2f valem R$%.2f Real", meuValorEmEuro, totalEmReal));
                }
                case "6" -> {
                    System.out.println("Digite o valor em Yuan para converter em Real");
                    cotacoesRates = cotacoes.buscarCotacao("CNY").conversion_rates();

                    double valorReal = cotacoesRates.get("BRL");

                    double meuValorEmYuan = scanner.nextDouble();
                    scanner.nextLine();

                    double totalEmReal = meuValorEmYuan * valorReal;
                    System.out.println(String.format("O seu valor em Yuan ¥%.2f valem R$%.2f Real", meuValorEmYuan, totalEmReal));
                }
                default -> System.out.println("Digite uma opção válida, entre 1 e 6");
            }

        } while (!escolherMoeda.equals("0"));


        scanner.close();

    }
}