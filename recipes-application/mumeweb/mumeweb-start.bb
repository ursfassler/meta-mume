SECTION = "app"
DESCRIPTION = "autostart for MUME D-Bus to web gateway"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd allarch

RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"

DEPENDS += " \
  nginx \
"

RDEPENDS_${PN} += " \
  mumeweb \
  mumesrv-start \
  dbus \
  nginx \
  spawn-fcgi \
"

SYSTEMD_SERVICE_mumeweb = "mumeweb.service"
SYSTEMD_AUTO_ENABLE_mumeweb = "enable"

SRC_URI = " \
	file://mumeweb.conf \
	file://mumeweb.service \
"

do_install_append() {
  install -d ${D}${sysconfdir}/nginx/conf.d/
  install -m 0644 ${WORKDIR}/mumeweb.conf ${D}${sysconfdir}/nginx/conf.d/

  install -d ${D}${systemd_unitdir}/system/
  install -m 0644 ${WORKDIR}/mumeweb.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} += " \
  ${systemd_unitdir}/system/* \
"

