// Criação da lista de tarefas
let listaDeTarefas = [];

// Loop para adicionar tarefas à lista
let adicionarTarefa = true;
while (adicionarTarefa) {
  let descricao = prompt('Digite a descrição da tarefa:');
  let tarefa = {
    descricao: descricao,
    concluida: false,
  };
  listaDeTarefas.push(tarefa);

  let continuar = prompt('Deseja adicionar mais tarefas? (s/n)').toLowerCase();
  adicionarTarefa = continuar === 's';
}

// Impressão da lista de tarefas
console.log('Lista de Tarefas:');
listaDeTarefas.forEach((tarefa, index) => {
  console.log(
    `${index + 1}. ${tarefa.descricao} - ${
      tarefa.concluida ? 'Concluída' : 'Pendente'
    }`
  );
});

// Uso do método map para criar uma lista de descrições
let descricaoTarefas = listaDeTarefas.map(tarefa => tarefa.descricao);
console.log('\nLista de Descrições de Tarefas:', descricaoTarefas);

// Uso do método filter para criar uma lista de tarefas concluídas
let tarefasConcluidas = listaDeTarefas.filter(tarefa => tarefa.concluida);
console.log('\nLista de Tarefas Concluídas:', tarefasConcluidas);

// Busca por uma tarefa específica usando o método find
let buscaDescricao = prompt('Digite a descrição da tarefa que deseja buscar:');
let tarefaEncontrada = listaDeTarefas.find(
  tarefa => tarefa.descricao === buscaDescricao
);

if (tarefaEncontrada) {
  console.log(`A tarefa ${buscaDescricao} foi encontrada!`);
} else {
  console.log(`A tarefa ${buscaDescricao} não foi encontrada.`);
}
