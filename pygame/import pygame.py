import pygame
pygame.init()

x = 0
y = 500
velocidade = 10
pulo = False
altura_pulo = 8
contagem_pulo = altura_pulo

pos_x = 600
pos_y = 600
velocidade_outros = 5
ponto_inicial = (550, 600)
ponto_final = (750, 600)
direcao = 1

fundo = pygame.image.load('fundocompleto.png')
boneco = pygame.image.load('donkey.png')
galinha = pygame.image.load('galinha.png')

janela = pygame.display.set_mode((1280, 600))
pygame.display.set_caption("COVID IX")

janela_aberta = True
while janela_aberta:
    pygame.time.delay(50)
    
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            janela_aberta = False

    comandos = pygame.key.get_pressed()
    if comandos[pygame.K_UP] and not pulo:
        pulo = True

    if comandos[pygame.K_LEFT] and x >= 0:
        x -= velocidade
    if comandos[pygame.K_RIGHT] and x <= 800 - boneco.get_width():
        x += velocidade

    if pulo:
        if contagem_pulo >= -altura_pulo:
            y -= (contagem_pulo * abs(contagem_pulo)) * 0.5
            contagem_pulo -= 1
        else:
            contagem_pulo = altura_pulo
            pulo = False
            y = 425

    pos_x += velocidade_outros * direcao

    if pos_x <= ponto_inicial[0] or pos_x >= ponto_final[0]:
        direcao *= -1

    if x + boneco.get_width() > pos_x and x < pos_x + galinha.get_width() and y + boneco.get_height() > pos_y and y < pos_y + galinha.get_height():
       x = 0
       y = 425

    janela.blit(fundo, (0, 0))
    janela.blit(boneco, (x, y))
    janela.blit(galinha, (pos_x, pos_y))
    pygame.display.update()

pygame.quit()