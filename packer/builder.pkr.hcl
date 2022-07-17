build {

  name = "linux-builder"
  source "source.amazon-ebs.vm" {
    ssh_username = "ec2-user"
  }
  provisioner "ansible" {
    playbook_file = "../ansible/application.yml"
    # command = "ansible-playbook.exe"
  }

  post-processor "manifest" {
    output     = "manifest.json"
    strip_path = true
    custom_data = {
      custom_data = "example"
    }
  }
}