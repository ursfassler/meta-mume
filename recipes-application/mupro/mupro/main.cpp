#include "FcgiRequest.hpp"
#include "SysFs.hpp"

#include <string>
#include <vector>

static const std::vector<std::string> files{
  "switch",
  "count",
  "modes",
  "mode",
  "close_pos_ns",
  "open_pos_ns",
};

static const std::string nl{"\r\n"};

int main(void)
{
  FcgiRequest request;

  request.init();

  while (request.accept()) {
    SysFs sysfs{"/sys/devices/platform/mume/"};

    request.out() << "Content-type: text/html" << nl << nl;

    request.out() << "<html>";

    request.out() << "<head>"
                  << "<title>MUME proof of concept</title>"
                  << "</head>";

    request.out() << "<body>";

    request.out() << "<h1>";
    request.out() << sysfs.path;
    request.out() << "</h1>";

    for (const auto& file : files) {
      request.out() << "<h2>";
      request.out() << file;
      request.out() << "</h2>";

      request.out() << "<p>";
      for (const auto& line : sysfs.read(file)) {
        request.out() << line;
        request.out() << "</br>";
      }
      request.out() << "<p>";
    }

    request.out() << "</body>";
    request.out() << "</html>";
  }

  return 0;
}
