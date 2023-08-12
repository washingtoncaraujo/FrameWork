class Pedido{
    constructor(id, valor, status){
        this.id = id;
        this.valor = valor;
        this.status = status
    }

}

var listaDePedidos = [];

let adicionarPedido = (id, valor, status) => {
    let pedido = new Pedido;
    pedido.id = id;
    pedido.valor = valor;
    pedido.status = status;
    listaDePedidos.push(pedido);
} 

let listarPedidosStatus = (situacao) => {
    let listaPedStat = listaDePedidos.filter((pedido) => pedido.status === situacao);
    console.log(listaPedStat);
    return listaPedStat;
}

let atualizarStatus = (id, newStatus) => {
    let listaStatus = listaDePedidos.findIndex((pedido) => pedido.id === id);
    listaDePedidos[listaStatus].status = newStatus;
}
// teste do código

adicionarPedido(100, 200.00, "Aguardando Pagamento");
adicionarPedido(150, 450.00, "Enviado");
adicionarPedido(80, 100.00, "Entregue");
adicionarPedido(200, 320.00, "Aguardando Pagamento");

listarPedidosStatus("Aguardando Pagamento");

atualizarStatus(80, "Pago");

