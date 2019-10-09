using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace DesktopApp
{
    /// <summary>
    /// Logique d'interaction pour FunFact.xaml
    /// </summary>
    public partial class FunFact : Window
    {
        public FunFact(string content)
        {
            InitializeComponent();
            if (content != "")
                this.textBlockFact.Text = content;
        }
    }
}
