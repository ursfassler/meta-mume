USE_RUBY_remove = " \
    qtquick1-dev \
    qtquick1-mkspecs \
    qtquick1-plugins \
    qtquick1-qmlplugins \
    qttranslations-qtquick1 \
    qtwebkit-dev \
    qtwebkit-mkspecs \
    qtwebkit-qmlplugins \
"

RDEPENDS_${PN}_remove = " \
    ${@base_contains('BBFILE_COLLECTIONS', 'ruby-layer', '${USE_RUBY}', '', d)} \
    ${@base_contains('DISTRO_FEATURES', 'wayland', '${USE_WAYLAND}', '', d)} \
    ${@base_contains('DISTRO_FEATURES', 'x11', '${USE_X11}', '', d)} \
    packagegroup-core-standalone-sdk-target \
    libsqlite3-dev \
    qt3d-dev \
    qt3d-mkspecs \
    qt3d-qmlplugins \
    qtconnectivity-dev \
    qtconnectivity-mkspecs \
    qtconnectivity-qmlplugins \
    qtdeclarative-dev \
    qtdeclarative-mkspecs \
    qtdeclarative-plugins \
    qtdeclarative-qmlplugins \
    qtdeclarative-staticdev \
    qtenginio-dev \
    qtenginio-mkspecs \
    qtenginio-qmlplugins \
    qtgraphicaleffects-qmlplugins \
    qtlocation-dev \
    qtlocation-mkspecs \
    qtlocation-plugins \
    qtlocation-qmlplugins \
    qtmultimedia-dev \
    qtmultimedia-mkspecs \
    qtmultimedia-plugins \
    qtmultimedia-qmlplugins \
    qtscript-dev \
    qtscript-mkspecs \
    qtsensors-dev \
    qtsensors-mkspecs \
    qtsensors-plugins \
    qtsensors-qmlplugins \
    qtsystems-dev \
    qtsystems-mkspecs \
    qtsystems-qmlplugins \
    qttools-plugins \
    qttranslations-qmlviewer \
    qttranslations-qt \
    qttranslations-qtbase \
    qttranslations-qtconfig \
    qttranslations-qtconnectivity \
    qttranslations-qtdeclarative \
    qttranslations-qthelp \
    qttranslations-qtlocation \
    qttranslations-qtmultimedia \
    qttranslations-qtscript \
    qttranslations-qtxmlpatterns \
    qtwebchannel-dev \
    qtwebchannel-mkspecs \
    qtwebchannel-qmlplugins \
    qtwebsockets-dev \
    qtwebsockets-mkspecs \
    qtwebsockets-qmlplugins \
"

RRECOMMENDS_${PN}_remove = " \
    qtquickcontrols-qmlplugins \
"
