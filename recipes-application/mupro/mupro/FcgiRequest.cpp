#include "FcgiRequest.hpp"


FcgiRequest::~FcgiRequest()
{
  cleanup();
}

void FcgiRequest::init()
{
  FCGX_Init();
  FCGX_InitRequest(&request, 0, 0);
}

bool FcgiRequest::accept()
{
  cleanup();

  if(FCGX_Accept_r(&request) != 0) {
    return false;
  }

  cin_fcgi_streambuf = new fcgi_streambuf(request.in);
  dataIn = new std::istream(cin_fcgi_streambuf);

  cout_fcgi_streambuf = new fcgi_streambuf(request.out);
  dataOut = new std::ostream(cout_fcgi_streambuf);

  //	fcgi_streambuf cerr_fcgi_streambuf(request.err);

  return true;
}

std::string FcgiRequest::param(const std::string &name)
{
  const auto value = FCGX_GetParam(name.c_str(), request.envp);
  if (value) {
    return std::string(value);
  } else {
    return {};
  }
}

void FcgiRequest::operator >>(std::string &stream)
{
  const auto content_length_str = param("CONTENT_LENGTH");
  unsigned long content_length = STDIN_MAX;

  if (content_length_str != "") {
    content_length = std::stoi(content_length_str);
    if (content_length > STDIN_MAX) {
      content_length = STDIN_MAX;
    }
  } else {
    content_length = 0;
  }

  char * content_buffer = new char[content_length];
  dataIn->read(content_buffer, content_length);
  content_length = dataIn->gcount();

  // Chew up any remaining stdin - this shouldn't be necessary
  // but is because mod_fastcgi doesn't handle it correctly.

  // ignore() doesn't set the eof bit in some versions of glibc++
  // so use gcount() instead of eof()...
  do {
    dataIn->ignore(1024);
  } while (dataIn->gcount() == 1024);

  stream.assign(content_buffer, content_length);
  delete [] content_buffer;
}

std::ostream &FcgiRequest::out()
{
  return *dataOut;
}

void FcgiRequest::cleanup()
{
  if (dataIn != nullptr) {
    delete dataIn;
    dataIn = nullptr;
  }
  if (cin_fcgi_streambuf != nullptr) {
    delete cin_fcgi_streambuf;
    cin_fcgi_streambuf = nullptr;
  }
  if (dataOut != nullptr) {
    delete dataOut;
    dataOut = nullptr;
  }
  if (cout_fcgi_streambuf != nullptr) {
    delete cout_fcgi_streambuf;
    cout_fcgi_streambuf = nullptr;
  }
}
