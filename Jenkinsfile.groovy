pipeline {
    agent any
    stages {
        stage('Packer - Build') {
            steps{
                sh """
                #!/bin/bash
                cd /var/lib/jenkins/workspace/TestProjectScripts/create_base_image/packer/
                /sbin/packer init .
                /sbin/packer build -force .
                """
            }
        }
    }
}