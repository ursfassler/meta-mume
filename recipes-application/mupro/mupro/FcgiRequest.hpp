#ifndef FCGIREQUEST_HPP
#define FCGIREQUEST_HPP

#include <fcgio.h>

#include <string>

class FcgiRequest final
{
  public:
    FcgiRequest(const FcgiRequest&) = delete;
    FcgiRequest &operator =(const FcgiRequest&) = delete;

    FcgiRequest() = default;
    ~FcgiRequest();

    void init();

    bool accept();

    std::string param(const std::string &name);

    void operator >>(std::string &stream);
    std::ostream &out();

  private:
    static const unsigned long STDIN_MAX{1000*1000};

    FCGX_Request request;

    fcgi_streambuf *cin_fcgi_streambuf{nullptr};
    std::istream *dataIn{nullptr};

    fcgi_streambuf *cout_fcgi_streambuf{nullptr};
    std::ostream *dataOut{nullptr};

    void cleanup();

};

#endif // FCGIREQUEST_HPP
