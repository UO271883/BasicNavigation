package es.uniovi.basicnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import es.uniovi.basicnavigation.databinding.FragmentHostBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HostFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HostFragment : Fragment(), View.OnClickListener{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentHostBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_host, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHostBinding.bind(view)

        binding.BTo1.setOnClickListener(this)
        binding.BTo2.setOnClickListener(this)
        binding.BTo3.setOnClickListener(this)

        /*binding.BTo1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fromh_to_1)
        }
        binding.BTo2.setOnClickListener {
            view.findNavController().navigate(R.id.action_fromh_to_2)
        }
        binding.BTo3.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fromh_to_3)
        }*/
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.BTo1.id -> {
                Navigation.findNavController(v).navigate(R.id.action_fromh_to_1)
            }
            binding.BTo2.id -> {
                v.findNavController().navigate(R.id.action_fromh_to_2)
            }
            binding.BTo3.id -> {
                /*var bundle = Bundle().apply {
                    putString("PARAMETER", "la pantalla host")
                }*/
                val action = HostFragmentDirections.actionFromhTo3("el fragmento host usadndo safeargs")
                v.findNavController().navigate(action)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HostFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HostFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}