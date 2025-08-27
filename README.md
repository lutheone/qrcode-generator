# QR Code Generator 📷⛆

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen)
![AWS SDK](https://img.shields.io/badge/AWS%20SDK-2.24.12-yellow)
![Google ZXing](https://img.shields.io/badge/Google%20ZXing-3.5.2-blue)
![Docker](https://img.shields.io/badge/Docker-✓-blue)
![Maven](https://img.shields.io/badge/Maven-3.9.6-red)

Este é um aplicativo Spring Boot que gera códigos QR e os armazena no AWS S3. O projeto demonstra a integração da biblioteca ZXing do Google para a geração de QR codes e o AWS S3 para armazenamento.

## Como Usar

### Pré-requisitos

- Java 17 JDK (ou superior)
- Maven
- Docker
- Conta AWS com acesso ao S3
- AWS CLI configurado com as credenciais apropriadas

### Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis:

```env
AWS_ACCESS_KEY_ID=your_access_key
AWS_SECRET_ACCESS_KEY=your_secret_key
AWS_REGION=your_region
AWS_BUCKET_NAME=your_bucket_name
```

### Executando o Aplicativo

#### Local Development

1. Crie o arquivo `.env` conforme descrito acima
2. Builde o projeto:
   ```bash
   mvn clean package
   ```
3. Execute:
   ```bash
   mvn spring-boot:run
   ```

#### Implantação com Docker

1. Builde a imagem Docker:
   ```bash
   docker build -t qrcode-generator:X.X . 
   ```
> Lembre-se de substituir a versão e o nome da imagem, se desejar.

2. Execute o contêiner:
   ```bash
   docker run --env-file .env -p 8080:8080 qrcode-generator:X.X 
   ```

> Lembre-se de substituir o caminho do arquivo `.env` para o caminho do seu arquivo de ambiente que você criou.

### Configuração do AWS S3

1. Crie um bucket S3 em sua conta AWS
2. Atualize o `AWS_BUCKET_NAME` no seu arquivo `.env` ou no comando de execução do Docker
3. Certifique-se de que suas credenciais AWS têm as permissões apropriadas para acessar o bucket S3

## Application Flow

<img width="1184" height="864" alt="flow" src="https://github.com/user-attachments/assets/747d61d0-0e6a-4a73-afa8-39639440c6c6" />


## API Endpoints

### POST /qrcode
Gera um QR code a partir do texto fornecido e o armazena no AWS S3. O QR code será gerado como uma imagem PNG com dimensões de 550x550 pixels.

**Parâmetros**

| Name | Required | Type | Description |
|------|----------|------|-------------|
| `text` | required | String | O conteúdo de texto a ser codificado no QR code. Pode ser qualquer valor de string que você deseja converter em um QR code. |

**Response**

```json
{
    "url": "https://your-bucket.s3.your-region.amazonaws.com/random-uuid"
}
```

**Error Response**

Se ocorrer um erro durante a geração do QR code ou o upload para o S3, a API retornará um erro 500 (Internal Server Error).

**Exemplo para usar**

```bash
curl -X POST http://localhost:8080/qrcode \
     -H "Content-Type: application/json" \
     -d '{"text": "https://example.com"}'
```
