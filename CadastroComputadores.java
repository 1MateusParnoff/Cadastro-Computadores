import java.util.ArrayList;
import java.util.Scanner;

class Computador {
    private String processador;
    private int ram;
    private String armazenamento;

    public Computador(String processador, int ram, String armazenamento) {
        this.processador = processador;
        this.ram = ram;
        this.armazenamento = armazenamento;
    }

    public String getProcessador() {
        return processador;
    }

    public int getRam() {
        return ram;
    }

    public String getArmazenamento() {
        return armazenamento;
    }
}

class Gamer extends Computador {
    private String placaDeVideo;

    public Gamer(String processador, int ram, String armazenamento, String placaDeVideo) {
        super(processador, ram, armazenamento);
        this.placaDeVideo = placaDeVideo;
    }

    public String getPlacaDeVideo() {
        return placaDeVideo;
    }
}

class Basico extends Computador {
    private boolean ssd;

    public Basico(String processador, int ram, String armazenamento, boolean ssd) {
        super(processador, ram, armazenamento);
        this.ssd = ssd;
    }

    public boolean temSsd() {
        return ssd;
    }
}

class Ios extends Computador {
    private String sistemaOperacional;

    public Ios(String processador, int ram, String armazenamento, String sistemaOperacional) {
        super(processador, ram, armazenamento);
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }
}

public class CadastroComputadores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Computador> computadores = new ArrayList<>();
        char opcao;

        do {
            System.out.println("Menu:");
            System.out.println("N - Novo Computador");
            System.out.println("L - Listar Computadores");
            System.out.println("G - Listar Computadores Gamer");
            System.out.println("B - Listar Computadores Básicos");
            System.out.println("I - Listar Computadores Ios");
            System.out.println("S - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.next().toUpperCase().charAt(0);

            switch (opcao) {
                case 'N':
                    novoComputador(scanner, computadores);
                    break;
                case 'L':
                    listarComputadores(computadores);
                    break;
                case 'G':
                    listarGamer(computadores);
                    break;
                case 'B':
                    listarBasico(computadores);
                    break;
                case 'I':
                    listarIos(computadores);
                    break;
                case 'S':
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 'S');

        scanner.close();
    }

    public static void novoComputador(Scanner scanner, ArrayList<Computador> computadores) {
        scanner.nextLine();

        System.out.print("Digite o tipo (G - Gamer, B - Básico, I - Ios): ");
        char tipo = scanner.next().toUpperCase().charAt(0);

        System.out.print("Digite o processador: ");
        scanner.nextLine();
        String processador = scanner.nextLine();

        System.out.print("Digite a quantidade de RAM (GB): ");
        int ram = scanner.nextInt();

        System.out.print("Digite o tipo de armazenamento: ");
        scanner.nextLine();
        String armazenamento = scanner.nextLine();

        Computador computador = null;
        if (tipo == 'G') {
            System.out.print("Digite o modelo da placa de vídeo: ");
            String placaDeVideo = scanner.nextLine();
            computador = new Gamer(processador, ram, armazenamento, placaDeVideo);
        } else if (tipo == 'B') {
            System.out.print("Possui SSD? (true/false): ");
            boolean ssd = scanner.nextBoolean();
            computador = new Basico(processador, ram, armazenamento, ssd);
        } else if (tipo == 'I') {
            System.out.print("Digite o sistema operacional: ");
            String sistemaOperacional = scanner.nextLine();
            computador = new Ios(processador, ram, armazenamento, sistemaOperacional);
        } else {
            System.out.println("Tipo inválido!");
            return;
        }
        computadores.add(computador);
        System.out.println("Computador cadastrado!");
    }

    public static void listarComputadores(ArrayList<Computador> computadores) {
        if (computadores.isEmpty()) {
            System.out.println("Nenhum computador cadastrado.");
        } else {
            System.out.println("Lista de Computadores:");
            for (Computador computador : computadores) {
                System.out.print("Processador: " + computador.getProcessador() + ", RAM: " + computador.getRam() + "GB, Armazenamento: " + computador.getArmazenamento());
                if (computador instanceof Gamer) {
                    System.out.println(", Placa de Vídeo: " + ((Gamer) computador).getPlacaDeVideo());
                } else if (computador instanceof Basico) {
                    System.out.println(", SSD: " + ((Basico) computador).temSsd());
                } else if (computador instanceof Ios) {
                    System.out.println(", Sistema Operacional: " + ((Ios) computador).getSistemaOperacional());
                }
            }
        }
    }

    public static void listarGamer(ArrayList<Computador> computadores) {
        boolean encontrou = false;
        for (Computador computador : computadores) {
            if (computador instanceof Gamer) {
                if (!encontrou) {
                    System.out.println("Lista de Computadores Gamer:");
                    encontrou = true;
                }
                System.out.println("Processador: " + computador.getProcessador() + ", RAM: " + computador.getRam() + "GB, Armazenamento: " + computador.getArmazenamento() +
                        ", Placa de Vídeo: " + ((Gamer) computador).getPlacaDeVideo());
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum computador gamer cadastrado.");
        }
    }

    public static void listarBasico(ArrayList<Computador> computadores) {
        boolean encontrou = false;
        for (Computador computador : computadores) {
            if (computador instanceof Basico) {
                if (!encontrou) {
                    System.out.println("Lista de Computadores Básicos:");
                    encontrou = true;
                }
                System.out.println("Processador: " + computador.getProcessador() + ", RAM: " + computador.getRam() + "GB, Armazenamento: " + computador.getArmazenamento() +
                        ", SSD: " + ((Basico) computador).temSsd());
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum computador básico cadastrado.");
        }
    }

    public static void listarIos(ArrayList<Computador> computadores) {
        boolean encontrou = false;
        for (Computador computador : computadores) {
            if (computador instanceof Ios) {
                if (!encontrou) {
                    System.out.println("Lista de Computadores Ios:");
                    encontrou = true;
                }
                System.out.println("Processador: " + computador.getProcessador() + ", RAM: " + computador.getRam() + "GB, Armazenamento: " + computador.getArmazenamento() +
                        ", Sistema Operacional: " + ((Ios) computador).getSistemaOperacional());
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum computador Ios cadastrado.");
        }
    }
}
