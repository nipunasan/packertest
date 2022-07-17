pipeline {
    agent any
    stages {
        stage('Packer - Build init') {
            steps{
                sh """
                #!/bin/bash
                export PACKER_LOG=1
                export PACKER_LOG_PATH=$WORKSPACE/packer.log
                echo "packer log path:" $PACKER_LOG_PATH
                cd ./packer/
                packer init .
                packer build -force .
                """
            }
        }
        stage('Packer - Build') {
            steps{
                sh """
                #!/bin/bash
                export PACKER_LOG=1
                export PACKER_LOG_PATH=$WORKSPACE/packer.log
                echo "packer log path:" $PACKER_LOG_PATH
                cd ./packer/
                packer build -force .
                """
            }
        }
    }
}