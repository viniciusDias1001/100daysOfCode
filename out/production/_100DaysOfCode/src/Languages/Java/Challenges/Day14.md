
# Gerador de CPF
Desafio:
Implemente um gerador de CPF em Java. O CPF (Cadastro de Pessoas Físicas) é um número de identificação individual atribuído a cada cidadão brasileiro. O CPF é composto por 11 dígitos, sendo que os dois últimos dígitos são chamados de dígitos verificadores.

Instruções:

Crie uma classe CPFGerador que seja responsável por gerar um CPF válido.
Implemente um método gerarCPF() na classe CPFGerador que retorne uma String contendo um CPF válido.
O CPF gerado deve seguir as seguintes regras:
Os nove primeiros dígitos devem ser gerados aleatoriamente.
Os dois últimos dígitos são calculados a partir dos nove primeiros dígitos, usando o algoritmo de verificação do CPF.
Implemente um método validarCPF(String cpf) na classe CPFGerador que receba um CPF como parâmetro e verifique se ele é válido.
No programa principal, demonstre o uso do gerador de CPF, gerando um CPF válido e verificando se ele é válido usando o método validarCPF().
Exemplo de saída:

CPF gerado: 123.456.789-09
O CPF gerado é válido? Sim


Neste exemplo, um CPF foi gerado aleatoriamente (123.456.789-09) e em seguida foi validado, confirmando que o CPF gerado é válido.

Observação: Certifique-se de implementar corretamente o algoritmo de verificação do CPF, levando em consideração os cálculos dos dígitos verificadores.

Implemente a solução seguindo as instruções acima.

Exemplo de entrada:

Quantos cpf quer gerar ?
1