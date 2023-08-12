// Criação da clasee Pedido
class Pedido{
    constructor(id, valor, status){
        this.id = id;
        this.valor = valor;
        this.status = status
    }
}

// Variável global com a lista dos pedidos
var listaDePedidos = [];

// Função para adicionar pedidos
let adicionarPedido = (id, valor, status) => {
    let pedido = new Pedido;
    pedido.id = id;
    pedido.valor = valor;
    pedido.status = status;
    listaDePedidos.push(pedido);
} 

// Função para lista pedidos por status
let listarPedidosStatus = (situacao) => {
    let listaPedStat = listaDePedidos.filter((pedido) => pedido.status === situacao);
    console.log(listaPedStat);
}

// Função para atualizar pedido
const atualizarStatus = (id, newStatus) => {
    let listaStatus = listaDePedidos.findIndex((pedido) => pedido.id === id);
    listaDePedidos[listaStatus].status = newStatus;
}

// Função para calcular total de pedidos
let calcularTotalPedidos = () => {
    let t = listaDePedidos.length;
    let valor;
    let total = 0;
    for(let i = 0; i < t; i ++){
        valor = listaDePedidos[i].valor;
        total = total + valor;
    }
    return total;
}
// teste do código
// Inserindo pedidos
adicionarPedido(1, 100.00, "Aguardando Pagamento");
adicionarPedido(2, 150.00, "Enviado");
adicionarPedido(3, 80.00, "Entregue");
adicionarPedido(4, 200.00, "Aguardando Pagamento");

// listando pedidos por status
console.log("Lista pedidos por Status: ");
listarPedidosStatus("Aguardando Pagamento");

// Atualizando status de pedido
console.log("Lista de pedidos original: ");
console.log(listaDePedidos);
atualizarStatus(3, "Pago");
console.log("Lista de pedidos atualizada: ");
console.log(listaDePedidos);

// Calculando total de pedidos
console.log(`Total de pedidos: R$ ${calcularTotalPedidos()}`);


