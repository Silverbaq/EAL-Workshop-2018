using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace BasicTokenWebAPI.Controllers
{
    [Route("api/[controller]")]
    public class TokenController : Controller
    {
        public class TokenRequest{
            public string username;
            public string password;
        }

        [AllowAnonymous]
        [HttpPost("gettoken")]
        public IActionResult RequestToken([FromBody] TokenRequest request)
        {
            if (request.username == "admin" && request.password == "password") // Only for demo use!
            {
                var claims = new[]
                {
                    new Claim(ClaimTypes.Name, request.username)
                };

                var key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes("ThisIsTheSecret!!!")); // Only for demo use!
                var creds = new SigningCredentials(key, SecurityAlgorithms.HmacSha256);

                var token = new JwtSecurityToken(
                    issuer: "yourdomain.com",
                    audience: "yourdomain.com",
                    claims: claims,
                    expires: DateTime.Now.AddMinutes(30),
                    signingCredentials: creds);

                return Ok(new
                {
                    token = new JwtSecurityTokenHandler().WriteToken(token)
                });
            }

            return BadRequest("Could not verify username and password");
        }
    }
}
