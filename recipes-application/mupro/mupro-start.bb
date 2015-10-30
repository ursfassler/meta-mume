SECTION = "app"
DESCRIPTION = "auto start MUME proof of concept fast cgi application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"

RDEPENDS_${PN} += " \
  nginx \
  spawn-fcgi \
  mupro \
"

SRC_URI = " \
	file://mupro.service \
	file://mupro.conf \
"

inherit systemd allarch

SYSTEMD_SERVICE_mupro = "mupro.service"
SYSTEMD_AUTO_ENABLE_mupro ?= "enable"

do_install_append() {
    install -d ${D}${sysconfdir}/nginx/conf.d/
    install -m 0644 ${WORKDIR}/mupro.conf ${D}${sysconfdir}/nginx/conf.d/

    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/mupro.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} += " \
  ${systemd_unitdir}/system/* \
"

