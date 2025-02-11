import { Router } from "express";

const router = Router();

router.get("/", (req, res) => {
  const html = `
    <!DOCTYPE html>
    <html>
      <head>
        <title>Web Programming UNIDEP</title>
        <style>
          body {
            margin: 0;
            padding: 0;
            overflow: hidden;
            height: 100vh;
            width: 100vw;
            background: linear-gradient(45deg, #6ab7f5, #f086d3);
          }
          .container {
            position: absolute;
            background-color: white;
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
            text-align: center;
            width: 200px;
            height: 100px;
            transition: transform 0.1s linear;
          }
          h1 {
            color: #333;
            margin-bottom: 1rem;
            font-size: 1.5em;
          }
          p {
            color: #666;
            font-size: 0.9em;
          }
        </style>
      </head>
      <body>
        <div class="container" id="container1">
          <h1>Hello World</h1>
          <p>Aula programação web UNIDEP 2025/1</p>
        </div>
        <div class="container" id="container2">
          <h1>Hello World 2</h1>
          <p>Aula programação web UNIDEP 2025/1</p>
        </div>

        <script>
          class MovingContainer {
            constructor(element, x, y, speedX, speedY) {
              this.element = element;
              this.x = x;
              this.y = y;
              this.speedX = speedX;
              this.speedY = speedY;
              this.width = element.offsetWidth;
              this.height = element.offsetHeight;
            }

            move() {
              this.x += this.speedX;
              this.y += this.speedY;

              // Colisão com as bordas da janela
              if (this.x <= 0 || this.x + this.width >= window.innerWidth) {
                this.speedX *= -1;
              }
              if (this.y <= 0 || this.y + this.height >= window.innerHeight) {
                this.speedY *= -1;
              }

              this.element.style.transform = \`translate(\${this.x}px, \${this.y}px)\`;
            }

            checkCollision(other) {
              const rect1 = this.element.getBoundingClientRect();
              const rect2 = other.element.getBoundingClientRect();

              if (rect1.left < rect2.right &&
                  rect1.right > rect2.left &&
                  rect1.top < rect2.bottom &&
                  rect1.bottom > rect2.top) {
                // Calculate collision direction
                const dx = (rect1.left + rect1.right) / 2 - (rect2.left + rect2.right) / 2;
                const dy = (rect1.top + rect1.bottom) / 2 - (rect2.top + rect2.bottom) / 2;


                if (Math.abs(dx) > Math.abs(dy)) {
                  this.speedX = Math.abs(this.speedX) * (dx > 0 ? 1 : -1);
                  other.speedX = Math.abs(other.speedX) * (dx > 0 ? -1 : 1);
                } else {
                  this.speedY = Math.abs(this.speedY) * (dy > 0 ? 1 : -1);
                  other.speedY = Math.abs(other.speedY) * (dy > 0 ? -1 : 1);
                }

                // Add a small separation to prevent sticking
                const separation = 1;
                if (Math.abs(dx) > Math.abs(dy)) {
                  this.x += dx > 0 ? separation : -separation;
                  other.x += dx > 0 ? -separation : separation;
                } else {
                  this.y += dy > 0 ? separation : -separation;
                  other.y += dy > 0 ? -separation : separation;
                }
              }
            }
          }

          const container1 = new MovingContainer(
            document.getElementById('container1'),
            100, 100, 3, 2
          );

          const container2 = new MovingContainer(
            document.getElementById('container2'),
            400, 300, -2, 3
          );

          function animate() {
            container1.move();
            container2.move();
            container1.checkCollision(container2);
            requestAnimationFrame(animate);
          }

          animate();
        </script>
      </body>
    </html>
  `;

  res.send(html);
});

export default router;
