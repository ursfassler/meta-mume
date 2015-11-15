SECTION = "app"
DESCRIPTION = "autostart for MUME D-Bus interface to hardware"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd allarch

RDEPENDS_${PN} += " \
  mumesrv \
"

SYSTEMD_SERVICE_mumesrv = "mumesrv.service"
SYSTEMD_AUTO_ENABLE_mumesrv = "enable"

SRC_URI = " \
	file://mumesrv.service \
"

do_install_append() {
  install -d ${D}${systemd_unitdir}/system/
  install -m 0644 ${WORKDIR}/mumesrv.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} += " \
  ${systemd_unitdir}/system/* \
"

