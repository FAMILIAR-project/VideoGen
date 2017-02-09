/**
 * generated by Xtext 2.10.0
 */
package org.xtext.example.mydsl.playlist.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.playlist.Mediafile;
import org.xtext.example.mydsl.playlist.PlaylistGeneratorModel;
import org.xtext.example.mydsl.playlist.PlaylistPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generator Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.playlist.impl.PlaylistGeneratorModelImpl#getMediafiles <em>Mediafiles</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlaylistGeneratorModelImpl extends MinimalEObjectImpl.Container implements PlaylistGeneratorModel
{
  /**
   * The cached value of the '{@link #getMediafiles() <em>Mediafiles</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMediafiles()
   * @generated
   * @ordered
   */
  protected EList<Mediafile> mediafiles;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PlaylistGeneratorModelImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return PlaylistPackage.Literals.PLAYLIST_GENERATOR_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Mediafile> getMediafiles()
  {
    if (mediafiles == null)
    {
      mediafiles = new EObjectContainmentEList<Mediafile>(Mediafile.class, this, PlaylistPackage.PLAYLIST_GENERATOR_MODEL__MEDIAFILES);
    }
    return mediafiles;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case PlaylistPackage.PLAYLIST_GENERATOR_MODEL__MEDIAFILES:
        return ((InternalEList<?>)getMediafiles()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case PlaylistPackage.PLAYLIST_GENERATOR_MODEL__MEDIAFILES:
        return getMediafiles();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PlaylistPackage.PLAYLIST_GENERATOR_MODEL__MEDIAFILES:
        getMediafiles().clear();
        getMediafiles().addAll((Collection<? extends Mediafile>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case PlaylistPackage.PLAYLIST_GENERATOR_MODEL__MEDIAFILES:
        getMediafiles().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case PlaylistPackage.PLAYLIST_GENERATOR_MODEL__MEDIAFILES:
        return mediafiles != null && !mediafiles.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PlaylistGeneratorModelImpl
