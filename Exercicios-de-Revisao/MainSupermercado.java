import java.util.ArrayList;

// ─────────────────────────────────────────────
//  AGREGAÇÃO: Produto
//  Existe no estoque independente de qualquer venda.
// ─────────────────────────────────────────────
class Produto {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }

    @Override
    public String toString() {
        return nome + " (R$ " + String.format("%.2f", preco) + ")";
    }
}

// ─────────────────────────────────────────────
//  AGREGAÇÃO: Cliente
//  Existe cadastrado na loja, independente de compras.
// ─────────────────────────────────────────────
class Cliente {
    private int id;
    private String nome;

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() { return nome; }
}

// ─────────────────────────────────────────────
//  COMPOSIÇÃO: ItemVenda
//
//  Um item de venda SÓ EXISTE dentro de uma Venda.
//  Fora dela, não faz sentido ter um "item" sozinho.
//
//  Mas ele AGREGA um Produto (que existe fora).
// ─────────────────────────────────────────────
class ItemVenda {
    private int id;
    private int quantidade;

    // AGREGAÇÃO dentro da composição: o produto existe fora da venda
    private Produto produto;

    public ItemVenda(int id, int quantidade, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public double calcularSubtotal() {
        return produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return String.format("  %-20s x%d  = R$ %.2f",
                produto.getNome(), quantidade, calcularSubtotal());
    }
}

// ─────────────────────────────────────────────
//  CLASSE "TODO": Venda
//
//  • AGREGA um Cliente (existe fora)
//  • É COMPOSTA por uma lista de ItemVenda
//    (os itens são criados dentro da Venda)
// ─────────────────────────────────────────────
class Venda {
    private int id;
    private Cliente cliente;                // AGREGAÇÃO
    private ArrayList<ItemVenda> itens;    // COMPOSIÇÃO
    private int proximoItemId = 1;

    public Venda(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    // COMPOSIÇÃO: o ItemVenda é criado aqui dentro
    public void adicionarItem(Produto produto, int quantidade) {
        ItemVenda item = new ItemVenda(proximoItemId++, quantidade, produto);
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("========== VENDA #").append(id).append(" ==========\n");
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        sb.append("------------------------------------\n");
        for (ItemVenda item : itens) {
            sb.append(item).append("\n");
        }
        sb.append("------------------------------------\n");
        sb.append(String.format("TOTAL: R$ %.2f\n", calcularTotal()));
        sb.append("====================================");
        return sb.toString();
    }
}

// ─────────────────────────────────────────────
//  Main
// ─────────────────────────────────────────────
public class MainSupermercado {
    public static void main(String[] args) {

        // Produtos existem no estoque (AGREGAÇÃO)
        Produto arroz  = new Produto(1, "Arroz 5kg",  22.90);
        Produto feijao = new Produto(2, "Feijão 1kg",  8.50);
        Produto oleo   = new Produto(3, "Óleo 900ml",  7.30);

        // Cliente cadastrado na loja (AGREGAÇÃO)
        Cliente cliente = new Cliente(1, "João da Silva");

        // Venda é o "todo" — cria itens internamente (COMPOSIÇÃO)
        Venda venda = new Venda(1001, cliente);
        venda.adicionarItem(arroz,  2);   // 2 pacotes de arroz
        venda.adicionarItem(feijao, 3);   // 3 pacotes de feijão
        venda.adicionarItem(oleo,   1);   // 1 garrafa de óleo

        System.out.println(venda);

        // Produtos continuam no estoque mesmo após a venda!
        System.out.println("\nArroz ainda disponível no estoque: " + arroz);
    }
}
