using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using System.Net;
using System.Threading;
using System.Text;
using System.Net.NetworkInformation;
namespace ICMPScanning
{
    static class Program
    {
          static void Main(string[] args)
        {
            Ping icmpClient = new Ping();
            PingOptions options = new PingOptions();
            options.DontFragment = true;
            byte[] msg = Encoding.UTF8.GetBytes("Scanning");

            while (true)
            {
                PingReply reply = icmpClient.Send("192.168.11.38", 500, msg, options);
                string responseReceived = Encoding.UTF8.GetString(reply.Buffer);
                Console.Write(DateTime.Now.ToString() + ": Respuesta del Host: ");
                if (responseReceived != String.Empty)
                    Console.WriteLine(responseReceived);
                else
                    Console.WriteLine("Tiempo agotado!");
                Thread.Sleep(500);
            }
        }

    }
}
