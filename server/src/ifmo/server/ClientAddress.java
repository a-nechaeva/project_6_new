package ifmo.server;
import java.net.InetAddress;

public record ClientAddress(InetAddress address, int port) {
}