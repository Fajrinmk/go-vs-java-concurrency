from http.server import BaseHTTPRequestHandler, HTTPServer
import time
import random

class SimpleHandler(BaseHTTPRequestHandler):
    def do_GET(self):
        # Send response status code
        self.send_response(200)
        # Send headers
        self.send_header('Content-type', 'text/html')
        self.end_headers()
        # Simulate some processing time in random range 50 - 150ms
        sleep_time = random.randint(50, 150) / 1000
        time.sleep(sleep_time)
        # Send message back to client
        message = "Request processed in %s ms" % (sleep_time * 1000)
        self.wfile.write(message.encode('utf-8'))
        return

def run(server_class=HTTPServer, handler_class=SimpleHandler, port=8080):
    server_address = ('', port)
    httpd = server_class(server_address, handler_class)
    print(f"Server running on port {port}")
    httpd.serve_forever()

if __name__ == '__main__':
    run()
