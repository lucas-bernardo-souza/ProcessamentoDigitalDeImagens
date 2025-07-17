# Processamento Digital De Imagens
Esse é um programa Java que processa arquivos de imagens, sua principais operações são:
1. Clareamento de imagens
   - Essa operação recebe uma matriz de inteiros que corresponde a imagem a ser clareada e um valor inteiro que será utilizado para subtração dos valores dos pixels da imagem. Ao final do processamento é retornado uma imagem mais clara
2. Destacar um intervalo
  - Essa operação atribui preto ou um valor passado por parâmetro aos pixels que estão dentro do intervalo determinado dentro da imagem.
3. Equalização de histograma
  - O objetivo dessa operação é melhorar o contraste de uma imagem espalhando os níveis de cinza mais frequentes. O programa implementa duas abordagens a equalização global que é aplicada em toda imagem a equalização local, aplicada em um local predeterminado da imagem. O método cria uma tabela de consulta com os valores de cinza, tudo isso é feito através do cálculo de probabilidade da ocorrência de cada nível de cinza. Com essa tabela de consulta os valores são substituidos na nova imagem.
4. Escurecer
  -Essa operação é semelhante a de clarear, com a diferença que aqui o parâmetro é subtraído dos pixels e não somado, fazendo com que os pixels fiquem mais próximos de zero.
5. Espelhamento
  - O programa realiza dois tipos de espelhamento, o vertical e o horizontal. O espelhamento horizontal inverte a imagem da esquerda para a direita, como se ela estivesse sendo refletida em um espelho vertical. Já o espelhamento vertical inverte a imagem de cima para baixo, a abordagem utilizada é trocar as linhas superiores com as inferiores. Por exemplo, ele copia a primeira linha para a posição da última linha e a última linha para a posição da primeira.

