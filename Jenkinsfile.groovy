pipeline {
    agent any
    stages {
        stage('Packer - Build') {
            steps{
                sh """
                #!/bin/bash
                cd ./packer/
                packer init .
                packer build -force .
                """
            }
        }
    }
}