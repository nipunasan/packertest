variable "region" {
  type    = string
  default = "us-east-1"
}

variable "instance_type" {
  type    = string
  default = "t2.micro"
}

variable "ami_name" {
  type    = string
  default = "linux-web-app"
}

variable "base_ami" {
  type    = string
  default = "ami-0cff7528ff583bf9a"
}

variable "subnet_id" {
  type    = string
  default = "subnet-25562c0a"
}

variable "security_group_id" {
  type    = string
  default = "sg-05d0984285622cbda"
}
