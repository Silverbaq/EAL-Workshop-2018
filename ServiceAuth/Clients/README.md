### Certificate Pinning
The purpose of Certificate and Public Key Pinning, is to have your client making sure that it is communicating with the endpoint you expect with no one interfering (Mitm) with the communication.

To do this, you can add the public key to the client, and have it validate the TLS certificate that the service is using.

OWASP has some guidelines about this:
https://www.owasp.org/index.php/Certificate_and_Public_Key_Pinning