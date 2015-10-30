#include "SysFs.hpp"

#include <fstream>

SysFs::SysFs(const std::string &aPath) :
  path(aPath)
{
}

std::vector<std::string> SysFs::read(const std::string &file) const
{
  std::ifstream fs{path+file};
  std::vector<std::string> content;

  if (fs.is_open()) {
    for(std::string line; std::getline(fs, line);){
      content.push_back(line);
    }
  }

  return content;
}

