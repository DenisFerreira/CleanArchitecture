# State

O padrão State sugere que você crie novas classes para todos os estados possíveis de um objeto e extraia todos os
comportamentos específicos de estados para dentro dessas classes.

Ao invés de implementar todos os comportamentos por conta própria, o objeto original, chamado contexto, armazena uma
referência para um dos objetos de estado que representa seu estado atual, e delega todo o trabalho relacionado aos
estados para aquele objeto.

O documento delega o trabalho para um objeto de estado O documento delega o trabalho para um objeto de estado.

Para fazer a transição do contexto para outro estado, substitua o objeto do estado ativo por outro objeto que represente
o novo estado. Isso é possível somente se todas as classes de estado seguirem a mesma interface e o próprio contexto
funcione com esses objetos através daquela interface.

Essa estrutura pode ser parecida com o padrão Strategy, mas há uma diferença chave. No padrão State, os estados em
particular podem estar cientes de cada um e iniciar transições de um estado para outro, enquanto que estratégias quase
nunca sabem sobre as outras estratégias.