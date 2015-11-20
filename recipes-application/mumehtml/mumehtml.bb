SECTION = "app"
DESCRIPTION = "MUME html pages"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit allarch

DEPENDS += "nginx"
RDEPENDS_${PN} += "nginx"

SRC_URI = " \
	file://mumehtml.conf \
	file://mume.html \
	file://mume.css \
	file://mume.js \
"

do_install_append() {
  install -d ${D}${sysconfdir}/nginx/conf.d/
  install -m 0644 ${WORKDIR}/mumehtml.conf ${D}${sysconfdir}/nginx/conf.d/
  
	install -d ${D}/var/www/mume
	install -m 0644 ${WORKDIR}/mume.html ${D}/var/www/mume/
	install -m 0644 ${WORKDIR}/mume.css ${D}/var/www/mume/
	install -m 0644 ${WORKDIR}/mume.js ${D}/var/www/mume/
}

