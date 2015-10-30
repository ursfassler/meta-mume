#ifndef SYSFS_HPP
#define SYSFS_HPP

#include <string>
#include <vector>

class SysFs
{
  public:
    SysFs(const std::string &path);

    const std::string path;

    std::vector<std::string> read(const std::string &file) const;


};

#endif // SYSFS_HPP
