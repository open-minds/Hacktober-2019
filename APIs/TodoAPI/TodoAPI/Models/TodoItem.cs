using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace TodoAPI.Models
{
    public class TodoItem
    {
        public int id { get; set; }
        public bool status { get; set; }
        public string task { get; set; }
        public string color { get; set; }
    }
}
