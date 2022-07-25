package com.huntinggame.activity.Main

import android.Manifest
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Display
import android.widget.ImageView
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.huntinggame.R
import com.huntinggame.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import com.sokolov.androidsizes.ISize
import com.sokolov.androidsizes.SizeFromImage
import com.huntinggame.utils.Common.FilePath

import androidx.lifecycle.ViewModelProvider
import com.huntinggame.utils.Common.ErrorUtil
import com.huntinggame.utils.Common.ViewModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import butterknife.BindView
import com.huntinggame.Fragment.*
import com.huntinggame.activity.CreateGame.CreateGameActivity
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_hunting.*
import java.io.FileOutputStream
import java.io.OutputStream
import android.content.res.Configuration as Configuration1


class MainActivity : AppCompatActivity() {
    private var previousSelectedRngeID: Int = 0
    private var imageCapture: ImageCapture? = null
    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService
    private lateinit var previousSelectedRngeIcon: Drawable
    lateinit var bin: ActivityMainBinding

    private lateinit var viewModel: ViewModel
    val bundle = Bundle()
    var doubleBackToExitPressedOnce = false

    //    @BindView(R.id.tvName)
//    lateinit var tvUserName: TextView


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            bin = ActivityMainBinding.inflate(layoutInflater)
            setContentView(bin.root)
            initView()
            lstnr()






//        if (allPermissionsGranted()) {
//            startCamera()
//        } else {
//            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
//        }
//        bin.imageView7.setOnClickListener {
//            takePhoto()
//        }
//        outputDirectory = getOutputDirectory()
//        cameraExecutor = Executors.newSingleThreadExecutor()
//
//        apiResponse()

        }


     override fun onConfigurationChanged(newConfig: android.content.res.Configuration) {
        super.onConfigurationChanged(newConfig)

        if(newConfig.orientation ==android.content.res.Configuration.ORIENTATION_LANDSCAPE){
            getActionBar()?.hide()
            view.visibility = View.GONE
            bin.bottomNavItemLay.verctor.visibility =  View.VISIBLE
        }
        else if(newConfig.orientation ==android.content.res.Configuration.ORIENTATION_PORTRAIT) {
            getActionBar()?.show()
            view.visibility = View.VISIBLE
            bin.bottomNavItemLay.verctor.visibility =  View.GONE
        }
     }

//
//    private fun apiResponse() {
//        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
//        //for chat list
//        viewModel.response.observe(this, {
//            if (it?.hit_rate !=null) {
//
//                onPopUp(it?.hit_rate)
//            }
//            else{
//                it?.hit_rate?.let { it1 -> onPopUp(it1) }
//                //Toast.makeText(applicationContext, it?.message, Toast.LENGTH_SHORT).show()
//            }
//        })
//        viewModel.error.observe(this, {
//            ErrorUtil.handlerGeneralError(this, it)
//            // finish()
//        })
//
//
//
//
//
//
//    }
//
//    private fun onPopUp(hitRate: Float) {
//
//
//        val builder = AlertDialog.Builder(this)
//        //set title for alert dialog
//        builder.setTitle("Hit rate")
//        //set message for alert dialog
//
//        if(hitRate!=null && hitRate !=0.0F){
//            builder.setMessage("Your hit rate is "+(hitRate*100).toString())
//        }else{
//            builder.setMessage("No animal found.")
//
//        }
//        builder.setIcon(android.R.drawable.ic_dialog_alert)
//
//        // Create the AlertDialog
//        val alertDialog: AlertDialog = builder.create()
//        // Set other dialog properties
//        alertDialog.setCancelable(true)
//        alertDialog.show()
//
//        //performing positive action
//        builder.setPositiveButton("Yes"){dialogInterface, which ->
//            alertDialog.dismiss()
//        }
//        //performing cancel action
//        builder.setNeutralButton("Cancel"){dialogInterface , which ->
//            alertDialog.dismiss()
//        }
//        //performing negative action
//        builder.setNegativeButton("No"){dialogInterface, which ->
//            alertDialog.dismiss()
//        }
//
//    }
//
//
//
//
//
//
//
//    private fun takePhoto() {
//        // Get a stable reference of the
//        // modifiable image capture use case
//        val imageCapture = imageCapture ?: return
//
//        // Create time-stamped output file to hold the image
//        val photoFile = File(
//            outputDirectory,
//            SimpleDateFormat(FILENAME_FORMAT, Locale.US).format(System.currentTimeMillis()) + ".jpg"
//        )
//
//        // Create output options object which contains file + metadata
//        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()
//
//        // Set up image capture listener,
//        // which is triggered after photo has
//        // been taken
//        imageCapture.takePicture(
//            outputOptions,
//            ContextCompat.getMainExecutor(this),
//            object : ImageCapture.OnImageSavedCallback {
//                override fun onError(exc: ImageCaptureException) {
//                    Log.e(TAG, "Photo capture failed: ${exc.message}", exc)
//                }
//
//                override  fun onImageSaved(output: ImageCapture.OutputFileResults) {
//                    val savedUri = Uri.fromFile(photoFile)
//
//                    // set the saved uri to the image view
////                    findViewById<ImageView>(R.id.iv_capture).visibility = View.VISIBLE
////                    findViewById<ImageView>(R.id.iv_capture).setImageURI(savedUri)
//
//
//                    try {
//                        // val uri: Uri = savedUri.getP
//                        val selectedFilePath = FilePath.getPath(application, savedUri)
//                        val file = File(selectedFilePath)
//
//
//                        val fullSizeIamge=BitmapFactory.decodeFile(selectedFilePath)
//
//
//                       // val scaledBitmap: Bitmap = scaleDown(fullSizeIamge, 1024, true)
//
//                    // val fils=   persistImage(scaledBitmap)
//
//                        val msg = "Photo capture succeeded my filw: ${file}"
//                       // val msgg = "Photo capture succeeded my filw: ${fils}"
//
//                        Log.d(TAG, "onImageSaved: ${msg}")
//                       // Log.d(TAG, "onImageSaved: ${msgg}")
//
//                        val size: ISize = SizeFromImage(savedUri.path)
//
//
//
//
//                        val hashMap: HashMap<String, Any> = HashMap()
//                        hashMap["scope_x"]= (size.width()/2).toString();
//                        hashMap["scope_y"]= (size.height()/2).toString();
//                        hashMap["scope_radius"]= dpToPx(106);
//                        hashMap["threshold"]= "200";
//
//
//                        val  profile_body = RequestBody.create("multipart-part/form-data".toMediaTypeOrNull(), file);
//
//                        val   profilePart =
//                            MultipartBody.Part.createFormData("file", file.getName(), profile_body);
//
//                        val scope_x= RequestBody.create(
//                            "multipart-part/form-data".toMediaTypeOrNull(),
//                            size.width().toString()
//                        );
//
//
//
//
//                        viewModel.onProcess(this@MainActivity,hashMap,profilePart)
//                        //viewModel.onProcess(this@MainActivity,multipartBody)
//
//
//
//                    } catch (e: java.lang.Exception) {
//                        e.printStackTrace()
//                    }
//
//                    val msg = "Photo capture succeeded: ${savedUri.path}"
//
//                    // Toast.makeText(baseContext, msg, Toast.LENGTH_LONG).show()
//                    Log.d(TAG, msg)
//                }
//            })
//    }
//
//    fun dpToPx(dp: Int): Float {
//        return (dp * Resources.getSystem().getDisplayMetrics().density) as Float
//    }
//

//    private fun persistImage(bitmap: Bitmap): File {
//       // val filesDir: File = sun.awt.AppContext.getAppContext().getFilesDir()
//        val imageFile = File(Environment.getExternalStorageDirectory() + File.separator + "reduce_size")
//        val os: OutputStream
//        val i = try {
//            os = FileOutputStream(imageFile)
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os)
//            os.flush()
//            os.close()
//
//            return imageFile
//        } catch (e: java.lang.Exception) {
//            Log.e(javaClass.simpleName, "Error writing bitmap", e)
//        }
//        return  imageFile
//    }

//
//    private fun startCamera() {
//        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
//
//        cameraProviderFuture.addListener(Runnable {
//
//            // Used to bind the lifecycle of cameras to the lifecycle owner
//            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
//
//            // Preview
//            val preview = Preview.Builder()
//                .build()
//                .also {
//                    it.setSurfaceProvider(viewFinder.createSurfaceProvider())
//                }
//
//            imageCapture = ImageCapture.Builder().build()
//
//            // Select back camera as a default
//            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
//
//            try {
//                // Unbind use cases before rebinding
//                cameraProvider.unbindAll()
//
//                // Bind use cases to camera
//                cameraProvider.bindToLifecycle(
//                    this, cameraSelector, preview, imageCapture
//                )
//
//            } catch (exc: Exception) {
//                Log.e(TAG, "Use case binding failed", exc)
//            }
//
//        }, ContextCompat.getMainExecutor(this))
//    }
//
//    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
//        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
//    }
//
//    // creates a folder inside internal storage
//    private fun getOutputDirectory(): File {
//        val mediaDir = externalMediaDirs.firstOrNull()?.let {
//            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
//        }
//        return if (mediaDir != null && mediaDir.exists())
//            mediaDir else filesDir
//    }
//
//    // checks the camera permission
//    override fun onRequestPermissionsResult(
//        requestCode: Int, permissions: Array<String>, grantResults:
//        IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == REQUEST_CODE_PERMISSIONS) {
//            // If all permissions granted , then start Camera
//            if (allPermissionsGranted()) {
//                startCamera()
//            } else {
//                // If permissions are not granted,
//                // present a toast to notify the user that
//                // the permissions were not granted.
//                Toast.makeText(this, "Permissions not granted by the user.", Toast.LENGTH_SHORT).show()
//                finish()
//            }
//        }
//    }
//
//    companion object {
//        private const val TAG = "CameraXGFG"
//        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
//        private const val REQUEST_CODE_PERMISSIONS = 20
//        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        cameraExecutor.shutdown()
//    }


        private fun initView() {





            ///Himanshu Code
//            if (intent.getBooleanExtra("himanshu",false)){
//               // childmain.visibility =View.VISIBLE
//                findViewById<ConstraintLayout>(R.id.childmain).visibility = View.VISIBLE
//                findViewById<ScrollView>(R.id.currentmain).visibility = View.GONE
//                val homeFragment = HuntingFragment()
//                homeFragment.arguments = bundle
//                supportFragmentManager
//                    .beginTransaction()
//                    .add(R.id.container, homeFragment, "huntingFrag")
//                    .commit()
//               // currentmain.visibility = View.INVISIBLE
//            }else{
//                findViewById<ConstraintLayout>(R.id.childmain).visibility = View.GONE
//                findViewById<ScrollView>(R.id.currentmain).visibility = View.VISIBLE
//                val homeFragment = HuntingFragment()
//                homeFragment.arguments = bundle
//                supportFragmentManager
//                    .beginTransaction()
//                    .add(R.id.container, homeFragment, "huntingFrag")
//                    .commit()
//            }
            val homeFragment = HuntingFragment()
            homeFragment.arguments = bundle
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, homeFragment, "huntingFrag")
                .commit()
//        val display: Display = windowManager.defaultDisplay
//        val width: Int = display.getWidth()
//        val height: Int = display.getHeight()
//
//        Log.d(TAG, "initView: $width")
//        Log.d(TAG, "initView: $height")
            prepareMovieData()
        }

        private fun lstnr() {

            fun onConfigurationChanged(newConfig: Configuration1?) {
                newConfig?.let { super.onConfigurationChanged(it) }
                if (newConfig != null) {
                    if (newConfig.orientation == Configuration1.ORIENTATION_LANDSCAPE) {

//                        Handler().postDelayed({
//                            otrosScrollView.fullScroll(ScrollView.FOCUS_UP)
//                        },600)

                    } else if (newConfig.orientation == Configuration1.ORIENTATION_PORTRAIT) {

//                        Handler().postDelayed({
//                            otrosScrollView.fullScroll(ScrollView.FOCUS_UP)
//                        },600)

                    }
                }
            }


        }

        private fun replaceFrag(frag: Fragment, nameTag: String, bundle: Bundle?) {
            if (bundle != null) frag.arguments = bundle else frag.arguments = null
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, frag, nameTag)
                .addToBackStack(nameTag)
                .commit()
        }

        private fun prepareMovieData() {

            bin.bottomNavItemLay.ivFocus
            bin.bottomNavItemLay.ivCal.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.ic_calbig)
            )

            ObjectAnimator.ofFloat(bin.bottomNavItemLay.ivCal, "translationY", -60f)
                .apply {
                    duration = 100
                    start()
                }
            previousSelectedRngeID = bin.bottomNavItemLay.ivCal.id
            previousSelectedRngeIcon = bin.bottomNavItemLay.ivCal.drawable


            bin.bottomNavItemLay.ivCal.setOnClickListener {
                make_range_selected_one(
                    bin.bottomNavItemLay.ivCal,
                    ContextCompat.getDrawable(this, R.drawable.ic_calbig)
                )
                val homeFragment = HuntingFragment()
                replaceFrag(homeFragment, "huntingFrag", null)

            }
            bin.bottomNavItemLay.ivMsg.setOnClickListener {
                make_range_selected_one(
                    bin.bottomNavItemLay.ivMsg,
                    ContextCompat.getDrawable(this, R.drawable.ic_msgbig)
                )
                val chatFragment = GameChatFragment()
                replaceFrag(chatFragment, "gamechatFrag", null)
            }
            bin.bottomNavItemLay.ivFocus.setOnClickListener {
                make_range_selected_one(bin.bottomNavItemLay.ivFocus,
                    ContextCompat.getDrawable(this, R.drawable.ic_binocular_new)
                )
                val focusFragment = FocusFragment()

                replaceFrag(focusFragment, "focusFrag", null)
            }
            bin.bottomNavItemLay.ivTrpy.setOnClickListener {
                make_range_selected_one(
                    bin.bottomNavItemLay.ivTrpy,
                    ContextCompat.getDrawable(this, R.drawable.ic_tropybig)
                )
                val leaderFragment = LeaderFragment()
                replaceFrag(leaderFragment, "leaderFrag", null)


            }
            bin.bottomNavItemLay.ivPerson.setOnClickListener {
                make_range_selected_one(
                    bin.bottomNavItemLay.ivPerson,
                    ContextCompat.getDrawable(this, R.drawable.ic_personbig)
                )
                val profileFragment = ProfileFragment()
                replaceFrag(profileFragment, "profileFrag", null)

            }

        }

        private fun make_range_selected_one(
            selected_range_lbl: ImageView,
            toSetIc: Drawable?

        ) {
            ObjectAnimator.ofFloat(selected_range_lbl, "translationY", -60f).apply {
                duration = 100
                start()
            }
            selected_range_lbl.setImageDrawable(toSetIc)
            selected_range_lbl.isEnabled = false
            findViewById<ImageView>(previousSelectedRngeID).isEnabled = true
            ObjectAnimator.ofFloat(findViewById(previousSelectedRngeID), "translationY", 0f).apply {
                duration = 100
                start()
            }

            when (previousSelectedRngeID) {
                bin.bottomNavItemLay.ivCal.id -> {
                    findViewById<ImageView>(previousSelectedRngeID).setImageResource(R.drawable.ic_cal)

                }
                bin.bottomNavItemLay.ivMsg.id -> {
                    findViewById<ImageView>(previousSelectedRngeID).setImageResource(R.drawable.ic_msg)

                }
                bin.bottomNavItemLay.ivFocus.id -> {
                    findViewById<ImageView>(previousSelectedRngeID).setImageResource(R.drawable.ic_binocular_nonactive_new)

                }
                bin.bottomNavItemLay.ivTrpy.id -> {
                    findViewById<ImageView>(previousSelectedRngeID).setImageResource(R.drawable.ic_tropy)

                }
                bin.bottomNavItemLay.ivPerson.id -> {
                    findViewById<ImageView>(previousSelectedRngeID).setImageResource(R.drawable.ic_person)

                }
            }
            previousSelectedRngeID = selected_range_lbl.id
        }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()

            return
        }
        this.doubleBackToExitPressedOnce = true

        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()
        make_range_selected_one(
            bin.bottomNavItemLay.ivCal,
            ContextCompat.getDrawable(this, R.drawable.ic_calbig)
        )

        val homeFragment = HuntingFragment()
        replaceFrag(homeFragment, "huntingFrag", null)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            doubleBackToExitPressedOnce = false

        }, 2000)
    }

    override fun onResume() {
        super.onResume()

         fun onConfigurationChanged(newConfig: android.content.res.Configuration) {
            super.onConfigurationChanged(newConfig)

            if(newConfig.orientation ==android.content.res.Configuration.ORIENTATION_LANDSCAPE){
                getActionBar()?.hide()
                view.visibility = View.GONE
                bin.bottomNavItemLay.verctor.visibility =  View.VISIBLE
            }
            else if(newConfig.orientation ==android.content.res.Configuration.ORIENTATION_PORTRAIT) {
                getActionBar()?.show()
                view.visibility = View.VISIBLE
            }
        }
    }



    }


