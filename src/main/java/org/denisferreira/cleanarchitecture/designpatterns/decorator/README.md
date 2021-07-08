# Decorator

* O Componente declara a interface comum tanto para os envoltórios como para os objetos envolvidos.

* O Componente Concreto é uma classe de objetos sendo envolvidos. Ela define o comportamento básico, que pode ser alterado por decoradores.

* A classe Decorador Base tem um campo para referenciar um objeto envolvido. O tipo do campo deve ser declarado assim como a interface do componente para que possa conter ambos os componentes concretos e os decoradores. O decorador base delega todas as operações para o objeto envolvido.

* Os Decoradores Concretos definem os comportamentos adicionais que podem ser adicionados aos componentes dinamicamente. Os decoradores concretos sobrescrevem métodos do decorador base e executam seus comportamentos tanto antes como depois de chamarem o método pai.

* O Cliente pode envolver componentes em múltiplas camadas de decoradors, desde que trabalhe com todos os objetos através da interface do componente.

