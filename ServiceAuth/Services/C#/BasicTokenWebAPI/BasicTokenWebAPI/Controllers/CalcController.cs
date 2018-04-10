using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace BasicTokenWebAPI.Controllers
{
    [Authorize]
    [Route("api/[controller]")]
    public class CalcController : Controller
    {
        
        [HttpGet("add")]
        public string Add(int a, int b){
            return (a + b).ToString();
        }

        [HttpGet("sub")]
        public string Sub(int a, int b)
        {
            return (a - b).ToString();
        }

        [HttpGet("div")]
        public string Div(double a, double b)
        {
            return (a / b).ToString();
        }

        [HttpGet("multi")]
        public string Multi(int a, int b)
        {
            return (a * b).ToString();
        }
    }
}
