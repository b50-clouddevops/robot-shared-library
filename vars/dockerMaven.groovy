def call() {
    node {
        sh 'rm -rf *'
        git branch: 'main', url: "https://github.com/b50-clouddevops/${COMPONENT}.git"
        
        stage('Image Build') {
            sh "mvn clean package"
            sh "mv target/shipping-1.0.jar shipping.jar"
        }
        stage('Docker Build') {
            sh "docker build ."
            sh "docker images"
        }
    }
}