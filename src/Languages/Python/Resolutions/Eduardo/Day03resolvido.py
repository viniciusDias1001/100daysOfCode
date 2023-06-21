# Entrada da quantidade de turmas e verificação
while True:
    try:
        n = int(input('Digite a quantidade de uniformes (1 ≤ N ≤ 60) da turma: '))
        if 1 <= n <= 60:
            break
        else:
            print('Digite um número no intervalo (1 ≤ N ≤ 60). ')
    except ValueError:
        print('Digite um número inteiro não negativo. ')

# Construção das listas dos alunos, cor da camisa e tamanho (P, M, G) de cada turma
i = 0
lista_aluno = []
lista_cor = []
lista_tamanho = []
while (i < n):
    aluno = input('Digite o nome do aluno: ')
    if aluno.isdigit():
        print('Por favor, digite um nome válido. ')
        continue
    lista_aluno.append(aluno)
    while True:
        cor = input('Cor do uniforme: [b] branco [v] vermelho: ')
        if cor.lower() == 'b':
            cor = 'branco'
            break
        elif cor.lower() == 'v':
            cor = 'vermelho'
            break
        else:
            print('Apenas branco ou vermelho disponível. ')
    lista_cor.append(cor)
    while True:
        tamanho = input('Digite o tamanho [P] [M] ou [G]: ')
        if tamanho.lower() == 'p':
            tamanho = 'tamanho P'
            break
        elif tamanho.lower() == 'm':
            tamanho = 'tamanho M'
            break
        elif tamanho.lower() == 'g':
            tamanho = 'tamanho G'
            break   
        else:
            print('Insira um tamanho válido, apenas letras. ')
    lista_tamanho.append(tamanho)
    i += 1

# Construção do dicionário de uniformes
lista_uniforme = {}
for j in range(len(lista_aluno)):
    lista_uniforme[lista_aluno[j]] = (lista_cor[j], lista_tamanho[j])

# Impressão dos uniformes para cada aluno
for aluno, uniforme in lista_uniforme.items():
    print(f'Aluno: {aluno}')
    print(f'Cor do uniforme: {uniforme[0]}')
    print(f'Tamanho: {uniforme[1]}')
    print()
