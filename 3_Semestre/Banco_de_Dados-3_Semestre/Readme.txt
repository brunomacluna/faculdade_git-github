PRETTY_NAME="Ubuntu 24.04.2 LTS"
NAME="Ubuntu"
VERSION_ID="24.04"
VERSION="24.04.2 LTS (Noble Numbat)"
VERSION_CODENAME=noble
ID=ubuntu
ID_LIKE=debian
HOME_URL="https://www.ubuntu.com/"
SUPPORT_URL="https://help.ubuntu.com/"
BUG_REPORT_URL="https://bugs.launchpad.net/ubuntu/"
PRIVACY_POLICY_URL="https://www.ubuntu.com/legal/terms-and-policies/privacy-policy"
UBUNTU_CODENAME=noble
LOGO=ubuntu-logo

####################
Instalação do Mysql

-- antes de qualquer instalação atualizados as bibliotecas
sudo apt update

-- sudo represente o adimin do Linux, o root
-- apt install - representa a forma em que o ubuntu instala os pacotes
-- mysql-server
sudo apt install mysql-server

-- sudo - adimin
-- systemctl - é o comando para acesso aos serviços do Linux ubuntu
-- start - stop -restart - status
-- nysql.service - nome do serviços
sudo systemctl start mysql.service
sudo systemctl status mysql.service

sudo mysql