''' var
 mat [1..3][1..5] de inteiro =
 {{1, 2, -1, 2, 3}, {1, -3, 4, 2, 0}, {-3, 5, 2, 3, 4}} 
 sl[1..3] de inteiro = {0, 0, 0} 
 x, i, j : inteiro
 x <- 0 
 início
 para i <- 1 até 3 faça
 para j <- 1 até 5 faça
 sl[i] <- sl[i] + mat[i][j]
 fimpara 
 x <- x + sl[i]
 fimpara
 imprima x
 fim
'''

mat = [[1,2,-1,2,3],[1,-3,4,2,0],[-3,5,2,3,4]]
sl = [0,0,0]
x = 0

for i in range(len(mat)): # função len(mat) retorna o tamanho (comprimento) da lista mat. 
    for j in range(len(mat[i])): # aqui função len(mat) vai percorrer as colunas que estão dentro das linhas que o outro for percorre 
        sl[i] = sl[i] + mat[i][j]
    x += sl[i]
print(x)

