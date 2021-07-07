# Chain of Responsibility

Como muitos outros padrões de projeto comportamental, o Chain of Responsibility se baseia em transformar certos
comportamentos em objetos solitários chamados handlers. No nosso caso, cada checagem devem ser extraída para sua própria
classe com um único método que faz a checagem. O pedido, junto com seus dados, é passado para esse método como um
argumento.

O padrão sugere que você ligue esses handlers em uma corrente. Cada handler ligado tem um campo para armazenar uma
referência ao próximo handler da corrente. Além de processar o pedido, handlers o passam adiante na corrente. O pedido
viaja através da corrente até que todos os handlers tiveram uma chance de processá-lo.

E aqui está a melhor parte: um handler pode decidir não passar o pedido adiante na corrente e efetivamente parar
qualquer futuro processamento.

Handlers estão alinhados um a um, formando uma corrente

Contudo, há uma abordagem ligeiramente diferente (e um tanto quanto canônica) na qual, ao receber o pedido, um handler
decide se ele pode processá-lo ou não. Se ele pode, ele não passa o pedido adiante. Então é um handler que processa o
pedido ou mais ninguém. Essa abordagem é muito comum quando lidando com eventos em pilha de elementos dentro de uma
interface gráfica de usuário.

Por exemplo, quando um usuário clica um botão, o evento se propaga através da corrente de elementos GUI que começam com
aquele botão, prossegue para seus contêineres (como planilhas ou painéis), e termina com a janela principal da
aplicação. O evento é processado pelo primeiro elemento na corrente que é capaz de lidar com ele. Esse exemplo também é
notável porque ele mostra que uma corrente pode sempre ser extraída de um objeto árvore.

Uma corrente pode ser formada por uma secção de um objeto árvore

É crucial que todas as classes handler implementem a mesma interface. Cada handler concreto deve se importar apenas se o
seguinte tem o método executar. Dessa maneira você pode compor correntes durante a execução, usando vários handlers sem
acoplar seu código com suas classes concretas.