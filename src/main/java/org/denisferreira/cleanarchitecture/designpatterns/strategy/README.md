# Strategy

O padrão Strategy sugere que você pegue uma classe que faz algo específico em diversas maneiras diferentes e extraia
todos esses algoritmos para classes separadas chamadas estratégias.

A classe original, chamada contexto, deve ter um campo para armazenar uma referência para um dessas estratégias. O
contexto delega o trabalho para um objeto estratégia ao invés de executá-lo por conta própria.

O contexto não é responsável por selecionar um algoritmo apropriado para o trabalho. Ao invés disso, o cliente passa a
estratégia desejada para o contexto. Na verdade, o contexto não sabe muito sobre as estratégias. Ele trabalha com todas
elas através de uma interface genérica, que somente expõe um único método para acionar o algoritmo encapsulado dentro da
estratégia selecionada.

Desta forma o contexto se torna independente das estratégias concretas, então você pode adicionar novos algoritmos ou
modificar os existentes sem modificar o código do contexto ou outras estratégias.