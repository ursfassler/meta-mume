LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL = " \
  packagegroup-core-boot \
  packagegroup-core-ssh-openssh \
  \
  bash \
  binutils \
  bzip2 \
  devmem2 \
  e2fsprogs \
  e2fsprogs-mke2fs \
  ethtool \
  evtest \
  file \
  gdb \
  gdbserver \
  htop \
  i2c-tools \
  iputils \
  libudev \
  mtd-utils \
  nginx \
  openssh-sftp \
  openssh-sftp-server \
  perf \
  procps \
  qtbase \
  qtbase-plugins \
  qtbase-tools \
  screen \
  strace \
  sysstat \
  tar \
  tcpdump \
  time \
  usbutils \
  wget \
"

IMAGE_FEATURES += " \
  package-management \
"

#IMAGE_BOOTLOADER = "u-boot"

