
# NimbusECR 🚀  

Welcome to **NimbusECR**! This  project demonstrates a full CI/CD pipeline using **GitHub Actions** to build and push a Dockerized Spring Boot application to **Amazon Elastic Container Registry (ECR)**. 🌩️

<img width="960" alt="18 (3)" src="https://github.com/user-attachments/assets/56f352b7-4a7c-44d5-8990-c72d1abb85d9">

## 📜 Table of Contents  
- [About the Project](#about-the-project)  
- [Features](#features)  
- [Prerequisites](#prerequisites)  
- [Getting Started](#getting-started)  
- [CI/CD Workflow Details](#cicd-workflow-details)  
- [Directory Structure](#directory-structure)  
- [Built With](#built-with)  

---

## 🔍 About the Project  

**NimbusECR** is a starter Spring Boot REST API application with a `hello world` endpoint, designed to showcase the following:  
- Building a Spring Boot application using **Maven**  
- Containerizing the application with **Docker**  
- Pushing the image to **Amazon Elastic Container Registry (ECR)** using **GitHub Actions**  
- Deploying and running the container on local or cloud environments  

---

## ✨ Features  
- 🌱 **Lightweight Spring Boot Starter App**: Minimalistic REST API for easy understanding.  
- 🐋 **Dockerized Build**: Containerized application for consistent deployments.  
- ☁️ **ECR Integration**: Pushes the Docker image to Amazon ECR seamlessly.  
- 🤖 **Automated CI/CD**: Utilizes GitHub Actions for build and push automation.  

---

## 🛠️ Prerequisites  

Before you begin, ensure you have the following:  
1. **AWS IAM User**:  
   - The IAM user should have the `AmazonEC2ContainerRegistryFullAccess` policy attached.  
2. **AWS CLI**: Installed and configured with credentials for the IAM user.  
3. **GitHub Secrets**: Set up the following secrets in your GitHub repository:  
   - `AWS_ACCESS_KEY_ID`  
   - `AWS_SECRET_ACCESS_KEY`  
   - `AWS_REGION`  
   - `AWS_ECR_REGISTRY`: The AWS account ID.  
   - `AWS_ECR_REPO_NAME`: The name of your ECR repository.  

4. **Docker**: Installed and configured on your local machine if you want to run the image locally.  

---

## 🚀 Getting Started  

### **Clone the Repository**  
```bash
git clone https://github.com/your-username/nimbus-ecr.git
cd nimbus-ecr
```

### **Run Locally**  
1. **Build the Project**:  
   ```bash
   mvn clean install
   ```  

2. **Build and Run Docker Container**:  
   ```bash
   docker build -t nimbusecr:local .
   docker run -p 8080:8080 nimbusecr:local
   ```  

3. **Access the Endpoint**:  
   Open your browser or use `curl` to hit:  
   ```bash
   curl http://localhost:8080/hello
   ```  

---

## 🤖 CI/CD Workflow Details  

### **GitHub Actions Workflow**  
The `.github/workflows/main.yml` file defines the CI/CD pipeline. Below is an explanation of each step:  

1. **Check Out the Code**:  
   Uses `actions/checkout@v4` to pull the code from the repository.  

2. **Set Up JDK**:  
   Installs OpenJDK 21 to build the Spring Boot application.  

3. **Clean Build Directory**:  
   Removes any previous build artifacts using `mvn clean`.  

4. **Build Project**:  
   Builds the Spring Boot JAR file using `mvn install`.  

5. **Configure AWS Credentials**:  
   Configures GitHub Actions to use your AWS credentials.  

6. **Login to Amazon ECR**:  
   Authenticates Docker to your Amazon ECR repository.  

7. **Build and Push Docker Image**:  
   - Builds the Docker image for the application.  
   - Pushes the image to your specified Amazon ECR repository.  

---

## 🗂️ Directory Structure  

```
nimbus-ecr/
├── src/                   # Application source code
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.demo/ # Your Spring Boot code
│   │   └── resources/     # Application resources
├── target/                # Compiled JAR and build artifacts
├── Dockerfile             # Docker configuration file
├── pom.xml                # Maven project file
└── .github/
    └── workflows/
        └── main.yml       # CI/CD workflow file
```

---

## 🛠️ Built With  

- **Spring Boot**: A Java framework for building RESTful APIs.  
- **Maven**: Dependency and build management.  
- **Docker**: Containerization platform.  
- **Amazon ECR**: Secure container registry.  
- **GitHub Actions**: CI/CD automation.  

---

## 📜 Example API Endpoint  

The application exposes a simple REST API:  

### `GET /`  

**Response**:  
```json
{
  "message": "server, online!"
}
```

---

## 🎉 Contributing  

Contributions are welcome! If you find any issues or have suggestions, feel free to open an issue or a pull request.  

---

## 📄 License  

This project is licensed under the MIT License.  

---

### 🚀 Ready to Deploy  

Once the Docker image is pushed to Amazon ECR, you can pull it and run it locally or deploy it in your AWS environment.  

```bash
# Authenticate Docker
aws ecr get-login-password --region <your-region> | docker login --username AWS --password-stdin <your-ecr-uri>

# Pull the image
docker pull <your-ecr-uri>:<tag>

# Run the container
docker run -p 8080:8080 <your-ecr-uri>:<tag>
```
---
### Proof Of Concepts

<img width="1512" alt="iam_user" src="https://github.com/user-attachments/assets/f6c1721a-2d6a-454c-8e67-f017fc495615">
<br>
<img width="1465" alt="image_ecr" src="https://github.com/user-attachments/assets/c1c08002-b48b-489f-8974-a81a33d8545e">
<br>
<img width="1547" alt="local_docker_logs" src="https://github.com/user-attachments/assets/5681789a-89b9-44a0-a4bd-f00d8b0ab667">
<br>
<img width="1547" alt="local_docker_logs" src="https://github.com/user-attachments/assets/0e18dcdf-ad65-4432-b8ec-953e516a5d78">
<br>
<img width="1342" alt="auth_ECR" src="https://github.com/user-attachments/assets/767bae3a-88fb-4b40-a3de-4034d7debae9">
<br>
<img width="1122" alt="create_aws_ecr_repo" src="https://github.com/user-attachments/assets/38157692-f08f-4e09-94a7-378bd9d0412b">
<br>
<img width="1467" alt="ecr_repo" src="https://github.com/user-attachments/assets/a38e6a8e-5dce-4297-a4d3-0cb6419d2d12">